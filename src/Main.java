import java.io.*;

public class Main {
    public static void main(String[] args) {

        File numbers = new File("numbers.txt");
        // Dosyanın var olup olmadığını kontrol etme
        if (!numbers.exists()) {
            try {
                numbers.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Dosya mevcut.");
        }

        int[] numArrays = {5, 10, 20, 12, 33};

        try {
            FileWriter fileWriter = new FileWriter(numbers, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < numArrays.length; i++) {
                // Tam sayıları dosyaya yazma
                bufferedWriter.write(Integer.toString(numArrays[i]));
                bufferedWriter.newLine();
            }
            // Buffer'ı boşaltma ve kaynakları serbest bırakma
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Tam sayılar dosyaya yazıldı.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int resault= 0;

        try {
            FileReader fileReader  = new FileReader(numbers);
            BufferedReader bufferedReader =new BufferedReader(fileReader);
            String line ;
            while((line=bufferedReader.readLine()) != null){
                resault+=Integer.parseInt(line);
            }
            System.out.println("Sayıların toplamı: "+resault);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
