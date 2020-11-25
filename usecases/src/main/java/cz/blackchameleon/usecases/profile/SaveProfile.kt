package cz.blackchameleon.usecases.profile

import cz.blackchameleon.data.repository.ProfileRepository
import cz.blackchameleon.domain.Profile

/**
 * @author Karolina Klepackova on 24.11.2020.
 */
class SaveProfile(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(profile: Profile) {
        profileRepository.saveProfile(profile)
    }
}