package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DictionaryFileReader {
    private String path;

    public DictionaryFileReader(String path){
        this.path = path;
    }

    public String getRawFileData(){
        try {
            FileInputStream fis = new FileInputStream(this.path);
            return readFromInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }


    public List<DictionaryValue> getDictionaryValues() {
        String[] arr = getRawFileData().split("\n");

        List<DictionaryValue> values = new ArrayList();

        for (var i = 0; i < arr.length; i++){
            String[] data = arr[i].split(",");

            Integer id = Integer.valueOf(data[0]);
            Integer intKey = Integer.valueOf(data[1]);
            String stringKey = data[2];
            String name = data[3];
            String value = data[4];

            DictionaryValue obj = new DictionaryValue(id, intKey, stringKey, name, value);
            values.add(obj);
        }

        return values;
    }
}
