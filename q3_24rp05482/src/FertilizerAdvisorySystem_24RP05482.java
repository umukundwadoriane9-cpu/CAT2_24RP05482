import java.util.ArrayList;
import java.util.List;

// --- 1. SoilAnalysis Class ---
/**
 * Represents a single soil sample analysis with nutrient levels and recommendation logic.
 */
class SoilAnalysis {
    private String farmerId;
    private String districtName;
    private double nitrogenLevel;
    private double phosphorusLevel;
    private double potassiumLevel;
    private String cropType;
    private boolean balanced;

    // Attributes from the diagram
    // private static int soilAnalysisCount = 0; 

    // Constructor to initialize all six fields
    public SoilAnalysis(String farmerId, String districtName, double nitrogenLevel, double phosphorusLevel, double potassiumLevel, String cropType) {
        this.farmerId = farmerId;
        this.districtName = districtName;
        this.nitrogenLevel = nitrogenLevel;
        this.phosphorusLevel = phosphorusLevel;
        this.potassiumLevel = potassiumLevel;
        this.cropType = cropType;
        this.balanced = isBalanced(); // Calculate balance status upon creation
        // soilAnalysisCount++;
    }

    // isBalanced() logic: true if N, P, K are all between 20 and 100 ppm (inclusive)
    public boolean isBalanced() {
        return (nitrogenLevel >= 20 && nitrogenLevel <= 100) &&
                (phosphorusLevel >= 20 && phosphorusLevel <= 100) &&
                (potassiumLevel >= 20 && potassiumLevel <= 100);
    }

    // Getters (included for completeness, though not all are used directly in main)
    public String getFarmerId() { return farmerId; }
    public String getDistrictName() { return districtName; }
    public String getCropType() { return cropType; }

    /**
     * Calculates the fertilizer recommendation based on the nutrient levels.
     * @return The fertilizer recommendation string.
     * @throws IllegalArgumentException If any nutrient is 0 or negative.
     */
    public String calculateFertilizerNeeded() throws IllegalArgumentException {
        // 1. Invalid Readings Check (0 or negative) - Must be first
        if (nitrogenLevel <= 0 || phosphorusLevel <= 0 || potassiumLevel <= 0) {
            throw new IllegalArgumentException("Invalid nutrient reading");
        }

        // 2. Optimal/Balanced Check (20-100 ppm inclusive)
        if (isBalanced()) {
            return "OPTIMAL - Maintenance fertilizer only";
        }

        // 3. Excess Check (> 100 ppm)
        StringBuilder excessNutrients = new StringBuilder();
        if (nitrogenLevel > 100) excessNutrients.append("Nitrogen");
        if (phosphorusLevel > 100) {
            if (excessNutrients.length() > 0) excessNutrients.append(", ");
            excessNutrients.append("Phosphorus");
        }
        if (potassiumLevel > 100) {
            if (excessNutrients.length() > 0) excessNutrients.append(", ");
            excessNutrients.append("Potassium");
        }

        if (excessNutrients.length() > 0) {
            return "EXCESS - Reduce " + excessNutrients.toString() + " application";
        }

        // 4. Deficient Check (< 20 ppm)
        StringBuilder deficientNutrients = new StringBuilder();
        if (nitrogenLevel < 20) deficientNutrients.append("Nitrogen");
        if (phosphorusLevel < 20) {
            if (deficientNutrients.length() > 0) deficientNutrients.append(", ");
            deficientNutrients.append("Phosphorus");
        }
        if (potassiumLevel < 20) {
            if (deficientNutrients.length() > 0) deficientNutrients.append(", ");
            deficientNutrients.append("Potassium");
        }

        if (deficientNutrients.length() > 0) {
            return "DEFICIENT - High application needed for " + deficientNutrients.toString();
        }

        return "Analysis inconclusive"; // Fallback, though logic should cover all cases
    }
}

// --- 2. FertilizerAdvisorySystem Class ---
/**
 * Main system class to run the soil analysis and generate the report.
 * (Placeholder for registration number used: 24RP00000)
 */
public class FertilizerAdvisorySystem_24RP05482 {

    public static void main(String[] args) {
        // Create the list of SoilAnalysis objects (Test Data)
        List<SoilAnalysis> samples = new ArrayList<>();

        // Required Diverse Test Data:
        samples.add(new SoilAnalysis("F001", "Kicukiro", 30, 70, 90, "Maize"));     // 1. Balanced Sample
        samples.add(new SoilAnalysis("F002", "Ngoma", 10, 45, 80, "Beans"));       // 2. Deficient Sample (N)
        samples.add(new SoilAnalysis("F003", "Nyagatare", 110, 90, 40, "Rice"));   // 3. Excess Sample (N)
        samples.add(new SoilAnalysis("F004", "Gasabo", -5, 40, 60, "Maize"));      // 4. Invalid Sample (N <= 0)
        samples.add(new SoilAnalysis("F005", "Huye", 15, 15, 18, "Rice"));         // 5. Highly Deficient Sample (N, P, K)

        // Variables for Summary Report
        int balancedSamples = 0;
        int deficientSamples = 0;
        int excessSamples = 0;
        int invalidSamples = 0;

        // Process each sample
        for (SoilAnalysis sample : samples) {
            System.out.println("Farmer ID: " + sample.getFarmerId());
            System.out.println("District: " + sample.getDistrictName());
            System.out.println("Crop Type: " + sample.getCropType());

            try {
                String recommendation = sample.calculateFertilizerNeeded();
                System.out.println("Recommendation: " + recommendation);

                // Update Summary Counts based on the recommendation (after successful calculation)
                if (recommendation.startsWith("OPTIMAL")) {
                    balancedSamples++;
                } else if (recommendation.startsWith("DEFICIENT")) {
                    deficientSamples++;
                } else if (recommendation.startsWith("EXCESS")) {
                    excessSamples++;
                }
            } catch (IllegalArgumentException e) {
                // Handle the invalid reading exception (F004)
                System.out.println("Error for Farmer ID " + sample.getFarmerId() + ": " + e.getMessage());
                invalidSamples++;
            }

            System.out.println(); // Add a blank line for separation
        }

        // Print Summary Report
        System.out.println("---------------------------------------------------");
        System.out.println("SUMMARY REPORT");
        System.out.println("---------------------------------------------------");
        System.out.println("Balanced Samples: " + balancedSamples);
        System.out.println("Deficient Samples: " + deficientSamples);
        System.out.println("Excess Samples: " + excessSamples);
        System.out.println("Invalid Samples: " + invalidSamples);
    }
}