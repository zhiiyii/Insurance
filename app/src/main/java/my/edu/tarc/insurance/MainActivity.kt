package my.edu.tarc.insurance

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import my.edu.tarc.insurance.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // binding.spinnerAge.setOnItemClickListener(this)
        binding.buttonCalculate.setOnClickListener {
            val age = binding.spinnerAge.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkBoxSmoker.isChecked
            var premium: Int

            if (age == 0) {
                // less than 17
                premium = 60
            }
            else if (age == 1) {
                // 17 - 25
                premium = 70
            }
            else if (age == 2) {
                // 26 - 30
                premium = 90
            }
            else if (age == 3) {
                // 31 - 40
                premium = 120
            }
            else {
                // more than 40
                premium = 150
            }

            /*
            when (age) {
                1 -> {}
                2 -> {}
                in 3...5 -> {}
            }
             */

            if (gender == R.id.radioButtonMale) {
                // calculate premium for male
                if (age == 1) {
                    // 17 - 25
                    premium += 50
                }
                else if (age == 2) {
                    // 26 - 30
                    premium += 100
                }
                else if (age == 3) {
                    // 31 - 40
                    premium += 150
                }
                else if (age == 4 || age == 5) {
                    // more than 40
                    premium += 200
                }
            }

            if (smoker) {
                // calculate premium for a smoker
                if (age == 1) {
                    // 17 - 25
                    premium += 100
                }
                else if (age == 2) {
                    // 26 - 30
                    premium += 150
                }
                else if (age == 3) {
                    // 31 - 40
                    premium += 200
                }
                else if (age == 4) {
                    // 41 - 55
                    premium += 250
                }
                else if (age == 5) {
                    // more than 55
                    premium += 300
                }
            }

            // display the final premium value
            val myLocale = Locale.getDefault()
            val myCurrency = Currency.getInstance(myLocale)
            // binding.textViewPremium.text = myCurrency.currencyCode + premium.toString()
            binding.textViewPremium.text = String.format("%s %d", myCurrency.currencyCode.toString(), premium)
        }
        binding.buttonReset.setOnClickListener {
            binding.spinnerAge.setSelection(0)
            binding.radioGroupGender.clearCheck()
            binding.checkBoxSmoker.isChecked = false
            binding.textViewPremium.setText("")
        }
    }

    /*
    override fun onItemClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        TODO("Not yet implemented")
    }
     */
}