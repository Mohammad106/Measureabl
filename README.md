import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ClaimApiTest {

    @Test
    public void testClaimApi() {
        // Fetch data from the database (you need to implement this)
        // For simplicity, I'll create some sample data
        String billedAmount = "795.00";
        String dosFrom = "2023-01-03";
        String dosTo = "2023-01-03";
        String localUseNo = "230602711968";
        String serviceCode = "A0428";
        String modifierCode = "HN";
        String units = "1";

        // Calculate date one month after DOSFrom
        LocalDate dosFromDate = LocalDate.parse(dosFrom, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate paidDate = dosFromDate.plusMonths(1);

        // Calculate amounts based on requirements
        double billedAmountValue = Double.parseDouble(billedAmount);
        double copay = 0.2 * billedAmountValue;
        double coinsurance = 0.1 * billedAmountValue;
        double deductible = 0.1 * billedAmountValue;
        double paidAmount = 0.4 * billedAmountValue;
        double adjustmentAmount = billedAmountValue - (paidAmount + copay + coinsurance + deductible);
        double allowedAmount = paidAmount + adjustmentAmount;

        // Build the JSON body
        JSONObject claimMessage = new JSONObject();
        JSONObject meta = new JSONObject();
        meta.put("Type", "TypeValue");
        meta.put("Client", "ClientValue");
        claimMessage.put("Meta", meta);

        JSONObject status = new JSONObject();
        status.put("Success", "TRUE");
        status.put("Code", "ICR000");
        status.put("Desc", "DescriptionValue");
        claimMessage.put("Status", status);

        JSONObject claim = new JSONObject();
        claim.put("LocalUseNo", localUseNo);
        claim.put("FormType", "HCFA");
        claim.put("PatientName", "PatientNameValue");
        claim.put("PatientDateOfBirth", "DateOfBirthValue");
        claim.put("PlanName", "FL");

        // Carrier Collection
        JSONObject carrierCollection = new JSONObject();
        carrierCollection.put("Carrier1", "Carrier1Value");
        carrierCollection.put("Carrier2", "Carrier2Value");
        carrierCollection.put("Carrier3", "Carrier3Value");
        claim.put("CarrierCollection", carrierCollection);

        claim.put("ResubmissionCode", "ResubmissionCodeValue");
        claim.put("FederalTaxid", "FederalTaxidValue");
        claim.put("TotalCharge", "TotalChargeValue");
        claim.put("PayToNameAndAddress", "PayToNameAndAddressValue");
        claim.put("PayTONPI", "PayTONPIValue");
        claim.put("IndividualProviderName", "IndividualProviderNameValue");
        claim.put("NPI", "NPIValue");

        // DiagCodeCollection
        JSONArray diagCodeCollection = new JSONArray();
        JSONObject diagCodeObject = new JSONObject();
        diagCodeObject.put("DiagCode", "DiagCodeValue");
        diagCodeCollection.put(diagCodeObject);
        claim.put("DiagCodeCollection", diagCodeCollection);

        // EobCollection
        JSONArray eobCollection = new JSONArray();
        JSONObject eobObject = new JSONObject();
        JSONObject eob = new JSONObject();
        eob.put("TotalBilledAmount", billedAmount);
        eob.put("TotalAllowedAmount", String.valueOf(allowedAmount));
        eob.put("TotalDeductibleAmount", String.valueOf(deductible));
        eob.put("TotalCoPayAmount", String.valueOf(copay));
        eob.put("TotalCoInsuranceAmount", String.valueOf(coinsurance));
        eob.put("TotalPaidAmount", String.valueOf(paidAmount));
        eob.put("TotalSequestrationAmount", "");
        eob.put("TotalAdjustmentAmount", String.valueOf(adjustmentAmount));
        eob.put("PayerPriorPaidAmount_C4", "");
        eob.put("OtherInsPayerName", "Texas BCBS");
        eob.put("OtherInsPayerid", "");
        eob.put("PaidDate", paidDate.format(DateTimeFormatter.ofPattern("M/d/yyyy")));

        // RemarkCodeCollection
        JSONArray remarkCodeCollection = new JSONArray();
        JSONObject remarkCodeObject1 = new JSONObject();
        remarkCodeObject1.put("RemarkCode", "C045");
        remarkCodeObject1.put("Glossary", "C045 - CHARGES EXCEED YOUR CONTRACTED/L");

        JSONObject remarkCodeObject2 = new JSONObject();
        remarkCodeObject2.put("RemarkCode", "");
        remarkCodeObject2.put("Glossary", "");

        remarkCodeCollection.put(remarkCodeObject1);
        remarkCodeCollection.put(remarkCodeObject2);

        eob.put("RemarkCodeCollection", remarkCodeCollection);

        // DetailCollection
        JSONArray detailCollection = new JSONArray();
        JSONObject detailObject = new JSONObject();
        JSONObject detail = new JSONObject();
        detail.put("DosFrom", dosFrom);
        detail.put("DosTo", dosTo);
        detail.put("ServiceCode", serviceCode);
        detail.put("ModifierCode", modifierCode);
        detail.put("BilledAmount", billedAmount);
        detail.put("Units", units);
        detail.put("SequestrationAmount", "");
        detail.put("COBPaid", String.valueOf(paidAmount));
        detail.put("CoInsuranceAmount", String.valueOf(coinsurance));
        detail.put("CoPay", String.valueOf(copay));
        detail.put("Deductible", String.valueOf(deductible));
        detail.put("AllowedAmount", String.valueOf(allowedAmount));

        // ReasonCodeCollection
        JSONArray reasonCodeCollection = new JSONArray();
        JSONObject reasonCodeObject1 = new JSONObject();
        reasonCodeObject1.put("ReasonCode", "C045");
        reasonCodeObject1.put("AdjustmentCode", "C045");
        reasonCodeObject1.put("AdjustmentAmount", String.valueOf(adjustmentAmount));

        JSONObject reasonCodeObject2 = new JSONObject();
        reasonCodeObject2.put("ReasonCode", "PR96");
        reasonCodeObject2.put("AdjustmentCode", "PR96");
        reasonCodeObject2.put("AdjustmentAmount", String.valueOf(adjustmentAmount));

        reasonCodeCollection.put(reasonCodeObject1);
        reasonCodeCollection.put(reasonCodeObject2);

        detail.put("ReasonCodeCollection", reasonCodeCollection);

        detailObject.put("Detail", detail);
        detailCollection.put(detailObject);

        eob.put("DetailCollection", detailCollection);

        eobObject.put("Eob", eob);
        eobCollection.put(eobObject);

        claim.put("EobCollection", eobCollection);

        claimMessage.put("Claim", claim);

        // API call using Rest Assured
        Response response = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(claimMessage.toString())
            .post("your_api_endpoint");

        // Validate response
        response.then().statusCode(200);

        // Further validation if needed
    }
}
