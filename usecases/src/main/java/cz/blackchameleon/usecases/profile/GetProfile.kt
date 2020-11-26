package cz.blackchameleon.usecases.profile

import cz.blackchameleon.data.Result
import cz.blackchameleon.data.repository.ProfileRepository
import cz.blackchameleon.domain.Profile

/**
 * Use case that returns profile dependent on id given
 * @param profileRepository Repository [ProfileRepository]
 *
 * @author Karolina Klepackova on 24.11.2020.
 */
class GetProfile(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(id: Int): Result<Profile> = profileRepository.getProfile(id)
}