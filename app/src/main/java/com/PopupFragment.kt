package com

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.pizza_delivery.R



class PopupFragment : DialogFragment() {



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val value = arguments?.getString("key_value", )
        val email = arguments?.getString("key_value_2", )
        builder.setTitle("Your order")
        builder.setMessage(email)
        builder.setPositiveButton("Confirm?") { dialog, which ->
            val recipient = "semah.mechi@gmail.com" // Replace with the recipient's email address
            val subject = "order"

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, email)

            startActivity(Intent.createChooser(intent, "Send Email"))
        }
        return builder.create()
    }
    companion object {
        fun newInstance(value: String,value2:String): PopupFragment {
            val fragment = PopupFragment()
            val args = Bundle()
            args.putString("key_value", value)
            args.putString("key_value_2", value2)
            fragment.arguments = args
            return fragment
        }
    }


}