package cz.blackchameleon.vanocka.ui.profile

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import cz.blackchameleon.vanocka.R
import cz.blackchameleon.vanocka.extensions.setImage
import cz.blackchameleon.vanocka.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment that handles UI for profile
 * @see BaseFragment
 *
 * @author Karolina Klepackova on 21.11.2020.
 */
class ProfileFragment : BaseFragment(R.layout.fragment_profile) {

    override val viewModel: ProfileViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        overlay.isVisible = true

        setupListeners()
        initObservers()
    }

    private fun setupListeners() {
        save_profile.setOnClickListener {
            viewModel.saveProfile()
        }
        edit_profile.setOnClickListener {
            Toast.makeText(context, resources.getString(R.string.does_nothing), Toast.LENGTH_LONG)
                .show()
        }
        delete_profile.setOnClickListener {
            viewModel.deleteProfile()
        }

        swipe_layout.setOnRefreshListener { viewModel.onSwipeReload() }
    }

    private fun initObservers() {
        viewModel.profile.observe(viewLifecycleOwner, { profile ->
            profile_name.text = profile.name
            profile_credits.text = resources.getString(R.string.credits, profile.credits)
            profile_photo.setImage(profile.photo)
            overlay.isVisible = false
            swipe_layout.isRefreshing = false
        })

        viewModel.showEmptyState.observe(viewLifecycleOwner, {
            no_data_text.isVisible = true
            swipe_layout.isVisible = false
            overlay.isVisible = false
        })
    }
}