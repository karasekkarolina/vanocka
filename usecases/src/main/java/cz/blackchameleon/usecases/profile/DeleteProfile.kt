package cz.blackchameleon.usecases.profile

import cz.blackchameleon.data.repository.ProfileRepository

/**
 * Use case that deletes all stored profiles
 * @param profileRepository Repository [ProfileRepository]
 *
 * @author Karolina Klepackova on 24.11.2020.
 */
class DeleteProfile(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke() {
        profileRepository.clean()
    }
}