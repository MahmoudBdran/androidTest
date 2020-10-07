package com.example.bdrancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
TextView zero ,one,two,three,four,five,six,seven,eight,nine,clear,mod,div,mul,add,sub,dot,double_zero,back;
FloatingActionButton equal;
TextView first_result_tv,second_result_tv,third_result_tv,fourth_result_tv,fifth_result_tv,exit_icon,Calc;
ImageView invert;
LinearLayout above_view;
RelativeLayout below_view,root_view;
String first_equ="0";
    boolean f=false;
    boolean dot_flag=false;
    boolean inverted=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        elementFlattening();
        onClickFun();
    }
    public void elementFlattening(){
        zero=findViewById(R.id.zero_btn);
        one=findViewById(R.id.one_btn);
        two=findViewById(R.id.two_btn);
        three=findViewById(R.id.three_btn);
        four=findViewById(R.id.four_btn);
        five=findViewById(R.id.five_btn);
        six=findViewById(R.id.six_btn);
        seven=findViewById(R.id.seven_btn);
        eight=findViewById(R.id.eight_btn);
        nine=findViewById(R.id.nine_btn);
        dot=findViewById(R.id.dot_btn);
        add=findViewById(R.id.add_btn);
        sub=findViewById(R.id.sub_btn);
        div=findViewById(R.id.div_btn);
        mul=findViewById(R.id.mul_btn);
        mod=findViewById(R.id.mod_btn);
        clear=findViewById(R.id.clear_btn);
        double_zero=findViewById(R.id.doubleZero_btn);
        back=findViewById(R.id.back_btn);
        equal=findViewById(R.id.equal);
        first_result_tv=findViewById(R.id.first_result_tv);
        second_result_tv=findViewById(R.id.second_result_tv);
        third_result_tv=findViewById(R.id.third_result_tv);
        fourth_result_tv=findViewById(R.id.fourth_result_tv);
        fifth_result_tv=findViewById(R.id.fifth_result_tv);
        exit_icon=findViewById(R.id.exit_icon);
        invert=findViewById(R.id.invert_colors);
        Calc=findViewById(R.id.Calc);
        above_view=findViewById(R.id.above_view);
        below_view=findViewById(R.id.below_view);
        root_view=findViewById(R.id.root_view);
    }
    public void onClickFun(){
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        clear.setOnClickListener(this);
        mod.setOnClickListener(this);
        div.setOnClickListener(this);
        mul.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        dot.setOnClickListener(this);
        double_zero.setOnClickListener(this);
        back.setOnClickListener(this);
        equal.setOnClickListener(this);
        exit_icon.setOnClickListener(this);
        invert.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.invert_colors:
                if (inverted==false){
                    invertColors();
                    inverted=true;
                }else if (inverted==true){
                    original_colors();
                    inverted=false;
                }

                break;
            case R.id.exit_icon:
                System.exit(0);
                break;
            case R.id.zero_btn:
                if (!TextUtils.isEmpty(first_result_tv.getText().toString())){
                    first_result_tv.append("0");
                }
                break;
            case  R.id.one_btn:
                first_result_tv.append("1");
                break;
            case  R.id.two_btn:
                first_result_tv.append("2");
                break;
            case  R.id.three_btn:
                first_result_tv.append("3");
                break;
            case  R.id.four_btn:
                first_result_tv.append("4");
                break;
            case  R.id.five_btn:
                first_result_tv.append("5");
                break;
            case  R.id.six_btn:
                first_result_tv.append("6");
                break;

            case  R.id.seven_btn:
                first_result_tv.append("7");

                break;
            case  R.id.eight_btn:
                first_result_tv.append("8");
                break;
            case  R.id.nine_btn:
                first_result_tv.append("9");
                break;
            case R.id.dot_btn:
                if (dot_flag==false){

                    String currentString =first_result_tv.getText().toString();
                    if (!currentString.contains(".")){
                        first_result_tv.append(".");
                        dot_flag=true;
                    }
                }
                break;
            case R.id.doubleZero_btn:
                if (!TextUtils.isEmpty(first_result_tv.getText().toString())) {
                    first_result_tv.append("00");
                }
                break;
            case R.id.back_btn:
                if (!TextUtils.isEmpty(first_result_tv.getText().toString())){
                    String new_text=first_result_tv.getText().toString().substring(0,first_result_tv.getText().toString().length()-1);
                    first_result_tv.setText(new_text);
                }
                break;
            case R.id.mod_btn:
                if (!TextUtils.isEmpty(first_result_tv.getText().toString())){
                    if (f==true&&first_result_tv.getText().toString()!=null){
                        secondMod();

                    }
                    if ("%".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            || "/".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            || "×".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            ||"+".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            ||"-".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))){

                        String new_text=first_result_tv.getText().toString().substring(0,first_result_tv.getText().toString().length()-1);
                        first_result_tv.setText(new_text+"%");
                        f=true;
                    }else{
                        first_result_tv.append("%");
                        f=true;
                    }


                }
                break;
            case R.id.div_btn:
                if (!TextUtils.isEmpty(first_result_tv.getText().toString())){
                    if (f==true&&first_result_tv.getText().toString()!=null){
                        secondMod();

                    }
                    if ("%".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            || "/".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            || "×".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            ||"+".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            ||"-".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))){

                        String new_text=first_result_tv.getText().toString().substring(0,first_result_tv.getText().toString().length()-1);
                        first_result_tv.setText(new_text+"/");
                        f=true;
                    }else{
                        first_result_tv.append("/");
                        f=true;
                    }


                }
                break;
            case R.id.mul_btn:
                if (!TextUtils.isEmpty(first_result_tv.getText().toString())){
                    if (f==true&&first_result_tv.getText().toString()!=null){
                        secondMod();

                    }
                    if ("%".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            || "/".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            || "×".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            ||"+".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            ||"-".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))){

                        String new_text=first_result_tv.getText().toString().substring(0,first_result_tv.getText().toString().length()-1);
                        first_result_tv.setText(new_text+"×");
                        f=true;
                    }else{
                        first_result_tv.append("×");
                        f=true;
                    }


                }
                break;
            case R.id.add_btn:
                if (!TextUtils.isEmpty(first_result_tv.getText().toString())){
                    if (f==true&&first_result_tv.getText().toString()!=null){
                        secondMod();

                    }
                    if ("%".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            || "/".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            || "×".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            ||"+".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            ||"-".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))){

                        String new_text=first_result_tv.getText().toString().substring(0,first_result_tv.getText().toString().length()-1);
                        first_result_tv.setText(new_text+"+");
                        f=true;
                    }else{
                        first_result_tv.append("+");
                        f=true;
                    }


                }
                break;
            case R.id.sub_btn:
                if (!TextUtils.isEmpty(first_result_tv.getText().toString())){
                    if (f==true&&first_result_tv.getText().toString()!=null){
                        secondMod();

                    }
                    if ("%".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            || "/".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            || "×".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            ||"+".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))
                            ||"-".equals(first_result_tv.getText().toString().substring(first_result_tv.getText().toString().length()-1))){

                        String new_text=first_result_tv.getText().toString().substring(0,first_result_tv.getText().toString().length()-1);
                        first_result_tv.setText(new_text+"-");
                        f=true;

                    }else{
                        first_result_tv.append("-");
                        f=true;
                    }


                }
                break;
            case R.id.clear_btn:
                first_result_tv.setText(null);
                break;
            case R.id.equal:
                if (!TextUtils.isEmpty(first_result_tv.getText().toString())){
                    equlFun();
                }
        }
    }
    private void equlFun() {
boolean flag=false;
String first_section="";
String second_section="";
char op='$';
double result=0;
        third_result_tv.setText(second_result_tv.getText().toString());

        if (!TextUtils.isEmpty(first_result_tv.getText().toString())){
            char arr[]=new char[first_result_tv.getText().toString().length()];
            for (int i = 0 ; i <first_result_tv.getText().toString().length();i++){
                arr[i]=first_result_tv.getText().toString().charAt(i);
                if (flag==false){
                    if (arr[i]=='%'||arr[i]=='*'||arr[i]=='+'||arr[i]=='-'||arr[i]=='×'){
                        switch (arr[i]){
                            case '%':
                                op='%';
                                break;
                            case '+':
                                op='+';
                                break;
                            case '-':
                                op='-';
                                break;
                            case '×':
                                op='×';
                                break;
                        }
                        flag=true;
                        continue;
                    }else{
                        first_section+=arr[i];
                    }
                }
               if (flag==true){
                    second_section+=arr[i];
                }
            }
            second_result_tv.setText(first_result_tv.getText().toString());

            if (op=='%')
            result=Double.parseDouble(first_section)%Double.parseDouble(second_section);
            else if (op=='×')
                result=Double.parseDouble(first_section)*Double.parseDouble(second_section);
            else if (op=='+')
                result=Double.parseDouble(first_section)+Double.parseDouble(second_section);
            else if (op=='-')
                result=Double.parseDouble(first_section)-Double.parseDouble(second_section);
            else if (op=='/')
                result=Double.parseDouble(first_section)/Double.parseDouble(second_section);
            //in case of one operator
            first_result_tv.setText(String.valueOf(result));
            f=false;
            dot_flag=false;
        }
    }
    private void secondMod(){
        boolean flag=false;
        String first_section="";
        String second_section="";
        char op='$';
        double result=0;
        third_result_tv.setText(second_result_tv.getText().toString());

        if (!TextUtils.isEmpty(first_result_tv.getText().toString())){
            char arr[]=new char[first_result_tv.getText().toString().length()];
            for (int i = 0 ; i <first_result_tv.getText().toString().length();i++){
                arr[i]=first_result_tv.getText().toString().charAt(i);
                if (flag==false){
                    if (arr[i]=='%'||arr[i]=='*'||arr[i]=='+'||arr[i]=='-'||arr[i]=='×'){
                        switch (arr[i]){
                            case '%':
                                op='%';
                                break;
                            case '+':
                                op='+';
                                break;
                            case '-':
                                op='-';
                                break;
                            case '×':
                                op='×';
                                break;
                        }
                        flag=true;
                        continue;
                    }else{
                        first_section+=arr[i];
                    }
                }
                if (flag==true){
                    second_section+=arr[i];
                }
            }
            second_result_tv.setText(first_result_tv.getText().toString());

            if (op=='%')
                result=Double.parseDouble(first_section)%Double.parseDouble(second_section);
            else if (op=='×')
                result=Double.parseDouble(first_section)*Double.parseDouble(second_section);
            else if (op=='+')
                result=Double.parseDouble(first_section)+Double.parseDouble(second_section);
            else if (op=='-')
                result=Double.parseDouble(first_section)-Double.parseDouble(second_section);
            else if (op=='/')
                result=Double.parseDouble(first_section)/Double.parseDouble(second_section);
            //in case of one operator
            first_result_tv.setText(String.valueOf(result));
        }
    }
    private void invertColors(){
        Calc.setTextColor(getResources().getColor(R.color.invert_text_color));
        exit_icon.setTextColor(getResources().getColor(R.color.invert_text_color));
        seven.setTextColor(getResources().getColor(R.color.invert_text_color));
        eight.setTextColor(getResources().getColor(R.color.invert_text_color));
        nine.setTextColor(getResources().getColor(R.color.invert_text_color));
        six.setTextColor(getResources().getColor(R.color.invert_text_color));
        five.setTextColor(getResources().getColor(R.color.invert_text_color));
        four.setTextColor(getResources().getColor(R.color.invert_text_color));
        three.setTextColor(getResources().getColor(R.color.invert_text_color));
        two.setTextColor(getResources().getColor(R.color.invert_text_color));
        one.setTextColor(getResources().getColor(R.color.invert_text_color));
        zero.setTextColor(getResources().getColor(R.color.invert_text_color));
        double_zero.setTextColor(getResources().getColor(R.color.invert_text_color));
        dot.setTextColor(getResources().getColor(R.color.invert_text_color));
        clear.setTextColor(getResources().getColor(R.color.invert_delete_color));
        back.setTextColor(getResources().getColor(R.color.invert_delete_color));
        above_view.setBackgroundColor(getResources().getColor(R.color.invert_above_background_color));
        below_view.setBackgroundDrawable(getDrawable(R.drawable.inverted_rounded_view));
        first_result_tv.setTextColor(getResources().getColor(R.color.invert_text_color));
        first_result_tv.setHintTextColor(getResources().getColor(R.color.invert_text_color));
        root_view.setBackgroundColor(getResources().getColor(R.color.invert_above_background_color));
    }
    private void original_colors() {
        Calc.setTextColor(getResources().getColor(R.color.textColor));
        exit_icon.setTextColor(getResources().getColor(R.color.textColor));
        seven.setTextColor(getResources().getColor(R.color.textColor));
        eight.setTextColor(getResources().getColor(R.color.textColor));
        nine.setTextColor(getResources().getColor(R.color.textColor));
        six.setTextColor(getResources().getColor(R.color.textColor));
        five.setTextColor(getResources().getColor(R.color.textColor));
        four.setTextColor(getResources().getColor(R.color.textColor));
        three.setTextColor(getResources().getColor(R.color.textColor));
        two.setTextColor(getResources().getColor(R.color.textColor));
        one.setTextColor(getResources().getColor(R.color.textColor));
        zero.setTextColor(getResources().getColor(R.color.textColor));
        double_zero.setTextColor(getResources().getColor(R.color.textColor));
        dot.setTextColor(getResources().getColor(R.color.textColor));
        clear.setTextColor(getResources().getColor(R.color.delete_color));
        back.setTextColor(getResources().getColor(R.color.delete_color));
        above_view.setBackgroundColor(getResources().getColor(R.color.above_background_coloe));
        below_view.setBackgroundDrawable(getDrawable(R.drawable.rounded_view));
        first_result_tv.setTextColor(getResources().getColor(R.color.textColor));
        first_result_tv.setHintTextColor(getResources().getColor(R.color.textColor));
        root_view.setBackgroundColor(getResources().getColor(R.color.above_background_coloe));
    }
}
