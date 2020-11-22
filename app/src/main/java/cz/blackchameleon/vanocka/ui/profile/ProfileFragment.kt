package cz.blackchameleon.vanocka.ui.profile

import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Karolina Klepackova on 21.11.2020.
 */

class ProfileFragment : BaseFragment(R.layout.fragment_profile) {

    override val viewModel: ProfileViewModel by viewModel()


}