package com.example.mycalculator.controler.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mycalculator.R;

import androidx.annotation.NonNull;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static final String BUNDLE_RESULT = "bundle_result";
    public static final String BUNDLE_MEMORY = "bundle_memory";
    public static final String BUNDLE_SHOW_PROCESS = "bundle_show_process";
    public static final String BUNDLE_SHOW_RESULT = "bundle_show_result";
    private Button mButtonClear;
    private Button mButtonAdd;
    private Button mButtonSub;
    private Button mButtonDivision;
    private Button mButtonMultiply;
    private Button mButtonEqual;
    private Button mButtonNumber0;
    private Button mButtonNumber1;
    private Button mButtonNumber2;
    private Button mButtonNumber3;
    private Button mButtonNumber4;
    private Button mButtonNumber5;
    private Button mButtonNumber6;
    private Button mButtonNumber7;
    private Button mButtonNumber8;
    private Button mButtonNumber9;
    private Button mPoint;
    private TextView mTextViewShowResult;
    private TextView mTextViewShowProcess;
    private float mOperand1;
    private float mOperand2;
    private float mResult;
    private float mMemory = 0;
    private int mPointCounter = 0;
    private int mOperatorCounter = 0;
    private boolean mAdd;
    private boolean mSubtract;
    private boolean mMultiply;
    private boolean mDivide;
    private boolean mEqual;
    private boolean mClear;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListener();
        if (savedInstanceState != null) {
            mMemory = savedInstanceState.getFloat(BUNDLE_MEMORY);
            mResult = savedInstanceState.getFloat(BUNDLE_RESULT);
            if (savedInstanceState.getString(BUNDLE_SHOW_RESULT) != null)
                mTextViewShowResult.setText(savedInstanceState.getString(BUNDLE_SHOW_RESULT) + "");
            if (savedInstanceState.getString(BUNDLE_SHOW_PROCESS) != null)
                mTextViewShowProcess.setText(savedInstanceState.getString(BUNDLE_SHOW_PROCESS) + "");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat(BUNDLE_RESULT, mResult);
        outState.putFloat(BUNDLE_MEMORY, mMemory);
        outState.putString(BUNDLE_SHOW_PROCESS, mTextViewShowProcess.getText().toString());
        outState.putString(BUNDLE_SHOW_RESULT, mTextViewShowResult.getText().toString());

    }

    private void findViews() {
        mButtonClear = findViewById(R.id.delete);
        mButtonDivision = findViewById(R.id.div);
        mButtonMultiply = findViewById(R.id.mul);
        mButtonSub = findViewById(R.id.sub);
        mButtonAdd = findViewById(R.id.adding);
        mButtonEqual = findViewById(R.id.equal);
        mPoint = findViewById(R.id.point);
        mButtonNumber0 = findViewById(R.id.num_0);
        mButtonNumber1 = findViewById(R.id.num_1);
        mButtonNumber2 = findViewById(R.id.num_2);
        mButtonNumber3 = findViewById(R.id.num_3);
        mButtonNumber4 = findViewById(R.id.num_4);
        mButtonNumber5 = findViewById(R.id.num_5);
        mButtonNumber6 = findViewById(R.id.num_6);
        mButtonNumber7 = findViewById(R.id.num_7);
        mButtonNumber8 = findViewById(R.id.num_8);
        mButtonNumber9 = findViewById(R.id.num_9);
        mTextViewShowResult = findViewById(R.id.textView);
        mTextViewShowProcess = findViewById(R.id.txt_pro);

    }

    private Boolean check() {
        String checkString = mTextViewShowProcess.getText().toString();
        if(checkString.length()>0){
        char checkChar = (checkString.charAt(checkString.length() - 1));
        if (checkChar != '+' || checkChar != '-' || checkChar != '*' || checkChar != '/' || checkChar != '.' || checkChar != ' ') {
            return true;
        } else
            return false;}
        return false;
    }


    private void setListener() {

        mButtonNumber0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewShowProcess.setText(mTextViewShowProcess.getText() + "0");
            }
        });
        mButtonNumber1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewShowProcess.setText(mTextViewShowProcess.getText() + "1");
            }
        });
        mButtonNumber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewShowProcess.setText(mTextViewShowProcess.getText() + "2");
            }

        });
        mButtonNumber3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewShowProcess.setText(mTextViewShowProcess.getText() + "3");
            }
        });
        mButtonNumber4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewShowProcess.setText(mTextViewShowProcess.getText() + "4");
            }
        });
        mButtonNumber5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewShowProcess.setText(mTextViewShowProcess.getText() + "5");
            }
        });
        mButtonNumber6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewShowProcess.setText(mTextViewShowProcess.getText() + "6");
            }
        });
        mButtonNumber7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewShowProcess.setText(mTextViewShowProcess.getText() + "7");
            }
        });
        mButtonNumber8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewShowProcess.setText(mTextViewShowProcess.getText() + "8");
            }
        });
        mButtonNumber9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewShowProcess.setText(mTextViewShowProcess.getText() + "9");
            }
        });
        mPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()) {
                    mTextViewShowProcess.setText(mTextViewShowProcess.getText() + ".");
                    mPointCounter++;
                }
            }
        });
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEqual) {
                    if (!mAdd && mOperatorCounter == 0) {
                        mTextViewShowProcess.setText(mTextViewShowProcess.getText() + " + ");
                        mAdd = true;
                        mOperatorCounter++;
                        mEqual = false;

                    }
                } else if (!mAdd && check() && mOperatorCounter == 0) {
                    mTextViewShowProcess.setText(mTextViewShowProcess.getText() + " + ");
                    mAdd = true;
                    mOperatorCounter++;

                }
                else {
                    calculate();
                    mTextViewShowProcess.setText(mTextViewShowProcess.getText() + " + ");
                    mAdd = true;
                    mOperatorCounter++;
                }
            }
        });

        mButtonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEqual) {
                    if (!mSubtract && mOperatorCounter == 0) {
                        mTextViewShowProcess.setText(mTextViewShowProcess.getText() + " - ");
                        mSubtract = true;
                        mOperatorCounter++;
                        mEqual = false;

                    }
                } else if (!mSubtract && check() && mOperatorCounter == 0) {
                    mTextViewShowProcess.setText(mTextViewShowProcess.getText() + " - ");
                    mSubtract = true;
                    mOperatorCounter++;
                } else {
                    calculate();
                    mTextViewShowProcess.setText(mTextViewShowProcess.getText() + " - ");
                    mSubtract = true;
                    mOperatorCounter++;
                }
            }
        });
        mButtonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEqual) {
                    if (!mMultiply && mOperatorCounter == 0) {
                        mTextViewShowProcess.setText(mTextViewShowProcess.getText() + " * ");
                        mMultiply = true;
                        mOperatorCounter++;
                        mEqual = false;

                    }
                } else if (!mMultiply && check() && mOperatorCounter == 0) {
                    mTextViewShowProcess.setText(mTextViewShowProcess.getText() + " * ");
                    mMultiply = true;
                    mOperatorCounter++;
                } else {
                    calculate();
                    mTextViewShowProcess.setText(mTextViewShowProcess.getText() + " * ");
                    mMultiply = true;
                    mOperatorCounter++;
                }
            }
        });
        mButtonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEqual) {
                    if (!mDivide && mOperatorCounter == 0) {
                        mTextViewShowProcess.setText(mTextViewShowProcess.getText() + " / ");
                        mDivide = true;
                        mOperatorCounter++;
                        mEqual = false;

                    }
                }
                if (!mDivide && check() && mOperatorCounter == 0) {

                    mTextViewShowProcess.setText(mTextViewShowProcess.getText() + " / ");
                    mDivide = true;
                    mOperatorCounter++;
                    mEqual = false;
                } else {
                    calculate();
                    mTextViewShowProcess.setText(mTextViewShowProcess.getText() + " / ");
                    mDivide = true;
                    mOperatorCounter++;
                }
            }
        });
        mButtonEqual.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                calculate();
                mEqual = true;
            }
        });
        mButtonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewShowProcess.setText("");
                mTextViewShowResult.setText("");
                mClear=true;
                mMemory=0;
//                mEqual=false;
//                mAdd=false;
//                mDivide=false;

            }
        });
    }

    private void calculate() {
        mOperatorCounter = 0;
        String[] strings = extractValueString(mTextViewShowProcess);
        if (mAdd) {
            if (strings[0].equals("")) {
                mOperand1 = mMemory;
            } else {

                mOperand1 = Float.parseFloat(strings[0]);

            }
            mOperand2 = Float.parseFloat(strings[2]);
            mResult = mOperand1 + mOperand2;
            mMemory = mResult;
            mTextViewShowResult.setText(mResult + "");
            mAdd = false;
            mResult = 0;
        }
        if (mSubtract) {
            if (strings[0].equals("")) {
                mOperand1 = mMemory;
            } else {
                mOperand1 = Float.parseFloat(strings[0]);
            }
            mOperand2 = Float.parseFloat(strings[2]);
            mResult = mOperand1 - mOperand2;
            mMemory = mResult;

            mTextViewShowResult.setText(mResult + "");
            mSubtract = false;
            mResult = 0;
        }
        if (mMultiply) {
            if (strings[0].equals("")) {
                mOperand1 = mMemory;
            } else {
                mOperand1 = Float.parseFloat(strings[0]);
            }
            mOperand2 = Float.parseFloat(strings[2]);
            mResult = mOperand1 * mOperand2;
            mMemory = mResult;
            mTextViewShowResult.setText(mResult + "");
            mMultiply = false;
            mResult = 0;
        }
        if (mDivide) {
            if (strings[0].equals("")) {
                mOperand1 = mMemory;
            } else {
                mOperand1 = Float.parseFloat(strings[0]);
            }
            mOperand2 = Float.parseFloat(strings[2]);
            if (mOperand2 != 0) {
                mResult = mOperand1 / mOperand2;
                mMemory = mResult;
                mTextViewShowResult.setText(mResult + "");
            } else {
                Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                mTextViewShowResult.setText("Cannot divide by zero");

            }
            mDivide = false;
            mResult = 0;
        }
        mTextViewShowProcess.setText("");
    }


    private String[] extractValueString(TextView textView) {
        String str = textView.getText().toString();
        String[] strArray = str.split(" ");
        return strArray;
    }
//
}
