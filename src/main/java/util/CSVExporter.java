
package util;

import java.io.FileWriter;
import java.util.List;

public class CSVExporter {

   public static void exportar(
           List<String> ranking
   ) {

       try {

           FileWriter writer =
                   new FileWriter("ranking.csv");

           writer.write("Jogador,Pontos\n");

           for (String linha : ranking) {

               writer.write(linha + "\n");
           }

           writer.close();

       } catch (Exception e) {

           e.printStackTrace();
       }
   }
}
