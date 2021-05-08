package com.company.task1_2;

import java.io.*;

public class test_task_1_2 {
    public static void main(String[] args) throws IOException {
        System.out.println("Task 1 and 2: class Vectors");
        VectorImpl a = new VectorImpl(new double[]{3, 4, 1, 2});
        VectorImpl b = new VectorImpl(new double[]{5, 2, 1, 3, 21, 43});
        Vectors vectors = new Vectors();
        OutputStream out1 = new ByteArrayOutputStream();
        Writer out2 = new CharArrayWriter();
        vectors.outputVector(a,out1);
        vectors.writeVector(b, out2);
        try {
            File file1 = new File("/Users/mac/Downloads/Practical_Task_2_1/src/com/company/files/testForVectorsInputStream.txt");
            File file2 = new File("/Users/mac/Downloads/Practical_Task_2_1/src/com/company/files/testForVectorsReader.txt");

            InputStream in1 = new FileInputStream(file1);
            System.setIn(in1);
            VectorImpl c = vectors.inputVector(in1);

            Reader in2 = new FileReader(file2);
            VectorImpl d = vectors.readVector(in2);

            vectors.writeVector(c,new CharArrayWriter());
            vectors.outputVector(d,new ByteArrayOutputStream());
        }
        catch (FileNotFoundException f){
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        VectorImpl vector = vectors.readVector(reader);
        vectors.outputVector(vector, new ByteArrayOutputStream());
    }
}
