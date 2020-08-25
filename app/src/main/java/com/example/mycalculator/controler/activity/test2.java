package com.example.mycalculator.controler.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mycalculator.R;

public class test2 extends AppCompatActivity {
    private Button mButton0;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button mButtonAdd;
    private Button mButtonSubtract;
    private Button mButtonDivide;
    private Button mButtonMultiple;
    private Button mButtonDot;
    private Button mButtonEqual;
    private Button mButtonClear;
    private TextView mTextView;



    float mOperand1, mOperand2;

    boolean mAddition, mSubtract, mMultiplication, mDivision;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        clickListener();
    }
    private void clickListener(){
        mButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mTextView.getText() + "0");
            }
        });
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mTextView.getText()+"1");
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mTextView.getText()+"2");
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mTextView.getText()+"3");
            }
        }); mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mTextView.getText()+"4");
            }
        }); mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mTextView.getText()+"5");
            }
        }); ; mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mTextView.getText()+"6");
            }
        }); mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mTextView.getText()+"7");
            }
        }); mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mTextView.getText()+"8");
            }
        });
        mButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mTextView.getText()+"9");
            }
        });
        mButtonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("");
            }
        });
        mButtonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mTextView.getText()+".");
            }
        });
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTextView==null)
                    mTextView.setText("");
                else{
                    mOperand1 = Float.parseFloat(mTextView.getText() + "");
                    mAddition = true;
                    mTextView.setText(null);

                }
            }
        });
        mButtonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOperand1 = Float.parseFloat(mTextView.getText() + "");
                mSubtract = true;
                mTextView.setText(null);
            }
        });
        mButtonMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOperand1 = Float.parseFloat(mTextView.getText() + "");
                mMultiplication = true;
                mTextView.setText(null);
            }
        });

        mButtonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOperand1 = Float.parseFloat(mTextView.getText() + "");
                mDivision = true;
                mTextView.setText(null);
            }
        });
        mButtonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOperand2 = Float.parseFloat(mTextView.getText() + "");

                if (mAddition == true) {
                    mTextView.setText(mOperand1 + mOperand2 + "");
                    mAddition = false;
                }

                if (mSubtract == true) {
                    mTextView.setText(mOperand1 - mOperand2 + "");
                    mSubtract = false;
                }

                if (mMultiplication == true) {
                    mTextView.setText(mOperand1 * mOperand2 + "");
                    mMultiplication = false;
                }

                if (mDivision == true) {
                    mTextView.setText(mOperand1 / mOperand2 + "");
                    mDivision = false;
                }
            }
        });
    }

    private void findViews() {
        mButton0 = findViewById(R.id.button_0);
        mButton1 = findViewById(R.id.button_1);
        mButton2 = findViewById(R.id.button_2);
        mButton3 = findViewById(R.id.button_3);
        mButton4 = findViewById(R.id.button_4);
        mButton5 = findViewById(R.id.button_5);
        mButton6 = findViewById(R.id.button_6);
        mButton7 = findViewById(R.id.button_7);
        mButton8 = findViewById(R.id.button_8);
        mButton9 = findViewById(R.id.button_9);
        mButtonAdd = findViewById(R.id.button_add);
        mButtonSubtract = findViewById(R.id.button_subtract);
        mButtonMultiple = findViewById(R.id.button_multiple);
        mButtonDivide = findViewById(R.id.button_divide);
        mButtonDot = findViewById(R.id.button_dot);
        mButtonEqual = findViewById(R.id.button_equal);
        mButtonClear = findViewById(R.id.button_c);
        mTextView = findViewById(R.id.text_view);

    }
}