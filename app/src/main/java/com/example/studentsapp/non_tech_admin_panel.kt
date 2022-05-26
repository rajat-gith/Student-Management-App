package com.example.studentsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_non_academic.*
import kotlinx.android.synthetic.main.fragment_non_academic.E_t
import kotlinx.android.synthetic.main.fragment_non_academic.Rs_t
import kotlinx.android.synthetic.main.fragment_non_academic.iic_t1
import kotlinx.android.synthetic.main.fragment_non_academic.sam_t1
import kotlinx.android.synthetic.main.fragment_non_academic.sou_t1
import kotlinx.android.synthetic.main.fragment_non_academic.spo_t1
import kotlinx.android.synthetic.main.fragment_non_academic.vc_t
import kotlinx.android.synthetic.main.fragment_non_academic.vib_t1
import kotlinx.android.synthetic.main.fragment_non_academic.view.*
import kotlinx.android.synthetic.main.fragment_non_academic.view.enigma
import kotlinx.android.synthetic.main.fragment_non_academic.view.RS
import kotlinx.android.synthetic.main.fragment_non_academic.view.dance1
import kotlinx.android.synthetic.main.fragment_non_academic.view.samavesh1
import kotlinx.android.synthetic.main.fragment_non_academic.view.souls1
import kotlinx.android.synthetic.main.fragment_non_academic.view.sports1
import kotlinx.android.synthetic.main.fragment_non_academic.view.vc1
import kotlinx.android.synthetic.main.fragment_non_tech_admin_panel.*
import kotlinx.android.synthetic.main.fragment_non_tech_admin_panel.view.*

class non_tech_admin_panel : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_non_tech_admin_panel, container, false)

        view.RS1.setOnClickListener {
            val action=non_tech_admin_panelDirections.actionNonTechAdminPanelToNonTechAdminDomain2(Rs_t1.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.enigma1.setOnClickListener {
            val action=non_tech_admin_panelDirections.actionNonTechAdminPanelToNonTechAdminDomain2(E_t1.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.iic.setOnClickListener {
            val action=non_tech_admin_panelDirections.actionNonTechAdminPanelToNonTechAdminDomain2(iic_t.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.vc.setOnClickListener {
            val action=non_tech_admin_panelDirections.actionNonTechAdminPanelToNonTechAdminDomain2(vc_t1.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.dance.setOnClickListener {
            val action=non_tech_admin_panelDirections.actionNonTechAdminPanelToNonTechAdminDomain2(vib_t.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.souls.setOnClickListener {
            val action=non_tech_admin_panelDirections.actionNonTechAdminPanelToNonTechAdminDomain2(sou_t.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.sports.setOnClickListener {
            val action=non_tech_admin_panelDirections.actionNonTechAdminPanelToNonTechAdminDomain2(spo_t.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        view.samavesh.setOnClickListener {
            val action=non_tech_admin_panelDirections.actionNonTechAdminPanelToNonTechAdminDomain2(sam_t.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
        return view
    }

}