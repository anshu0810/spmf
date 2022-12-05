package ca.pfv.spmf.algorithms.frequentpatterns.eclat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import ca.pfv.spmf.algorithms.frequentpatterns.eclat.AlgoEclatm;
import ca.pfv.spmf.input.transaction_database_list_integers.TransactionDatabase;

class AlgoEclatmTest {
    public static void main(String [] arg) throws IOException {

        // the file paths
        String input = fileToPath("testdm.txt");  // the database
        String output = ".//output.txt";  // the path for saving the frequent itemsets found

        // minimum support
        double minsup = 0.1; // means a minsup of 2 transaction (we used a relative support)

        // Loading the transaction database
        TransactionDatabase database = new TransactionDatabase();
        try {
            database.loadFile(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
//		context.printContext();

        // Applying the ECLAT algorithm
        AlgoEclatm algo = new AlgoEclatm();
        algo.runAlgorithm(output, database, minsup, false);
        // if you change use "true" in the line above, ECLAT will use
        // a triangular matrix  for counting support of itemsets of size 2.
        // For some datasets it should make the algorithm faster.

        algo.printStats();

    }

    public static String fileToPath(String filename) throws UnsupportedEncodingException {
        URL url = ca.pfv.spmf.test.MainTestEclat_saveToFile.class.getResource(filename);
        return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
    }
}

