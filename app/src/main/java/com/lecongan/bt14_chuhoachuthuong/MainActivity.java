package com.lecongan.bt14_chuhoachuthuong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class MainActivity extends AppCompatActivity {
    private Button btnTinh;
    private EditText edtString;
    private TextView tvKq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTinh = (Button) findViewById(R.id.btn_thuc_hien);
        edtString = (EditText) findViewById(R.id.edt_chuoi);
        tvKq = (TextView) findViewById(R.id.tv_kq);
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi = edtString.getText().toString();
                //-----------------CÁCH 2-----------------------------------------
//                toTitleCase(chuoi);//cach 2

                //-------------------------------CÁCH 3---------------------------------
//                capitalize(chuoi);//cach3 chưa hoàn thành

                //----------------------------CÁCH 4----------------------------
                capEachWord(chuoi);//cách 4

               // ----------------------CÁCH 5------------------------------
//                String result = capita(chuoi);
//                tvKq.setText(result);
                //-----------------------CÁCH 1--------------------
//                StringBuffer stringbf = new StringBuffer();

                //-----------------Cách 6----------------------
//                Pattern pattern = Pattern.compile("\\b([a-z])([\\w]*)");
//                Matcher matcher = pattern.matcher(chuoi);
//                StringBuffer buffer = new StringBuffer();
//                while (matcher.find()) {
//                    matcher.appendReplacement(buffer, matcher.group(1).toUpperCase() + matcher.group(2));
//                }
//                String capitalized = matcher.appendTail(buffer).toString();
//                tvKq.setText(capitalized);
                //

//                Matcher m = Pattern.compile("([a-z])([a-z]*)",
//                        Pattern.CASE_INSENSITIVE).matcher(chuoi);
//                while (m.find()) {
//                    m.appendReplacement(stringbf,
//                            m.group(1).toUpperCase() + m.group(2).toLowerCase());
//                }
//
//
//                tvKq.setText(chuoi.toUpperCase()+"\n"+chuoi.toLowerCase()+"\n"+m.appendTail(stringbf).toString());
                //----------------------------------------------


            }
        });
    }

    public String capita(String str){

     /* The first thing we do is remove whitespace from string */
        String c = str.replaceAll("\\s+", " ");
        String s = c.trim();
        String l = "";

        for(int i = 0; i < s.length(); i++){
            if(i == 0){                              /* Uppercase the first letter in strings */
                l += s.toUpperCase().charAt(i);
                i++;                                 /* To i = i + 1 because we don't need to add
                                                    value i = 0 into string l */
            }

            l += s.charAt(i);

            if(s.charAt(i) == 32){                   /* If we meet whitespace (32 in ASCII Code is whitespace) */
                l += s.toUpperCase().charAt(i+1);    /* Uppercase the letter after whitespace */
                i++;                                 /* Yo i = i + 1 because we don't need to add
                                                   value whitespace into string l */
            }
        }
        return l;
    }

    public void capEachWord(String source){
        String result = "";
        String[] splitString = source.split(" ");
        for(String target : splitString){
            result += Character.toUpperCase(target.charAt(0))
                    + target.substring(1) + " ";
        }
        tvKq.setText(result.trim());
    }

    ///CHu cai dau khong in hoa capitalize
    public void capitalize(String text){
        String c = (text != null)? text.trim() : "";
        String[] words = c.split(" ");
        String result = "";
        for(String w : words){
            result += (w.length() > 1? w.substring(0, 1).toUpperCase(Locale.US) + w.substring(1, w.length()).toLowerCase(Locale.US) : w) + " ";
        }
        tvKq.setText(result.trim());
    }

    public void toTitleCase(String givenString) {
        String[] arr = givenString.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            sb.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }
       tvKq.setText(sb.toString().trim());
    }
}
