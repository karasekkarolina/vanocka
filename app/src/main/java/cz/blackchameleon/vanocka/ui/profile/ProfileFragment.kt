package cz.blackchameleon.vanocka.ui.profile

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.ui.base.BaseFragment
import kotlinx.android.synthetic.main.loading_overlay.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Karolina Klepackova on 21.11.2020.
 */

class ProfileFragment : BaseFragment(R.layout.fragment_profile) {

    override val viewModel: ProfileViewModel by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.profileId = TESTING_PROFILE_ID
        initObservers()
    }

    private fun initObservers() {
        viewModel.profile.observe(viewLifecycleOwner, {
            // Todo update data
        })

        viewModel.loading.observe(viewLifecycleOwner, { visible ->
            loading_overlay.isVisible = visible
        })

        viewModel.showError.observe(viewLifecycleOwner, {
            // TODO show error state
        })
    }

    private companion object {
        private const val TESTING_PROFILE_ID = 456
    }
}