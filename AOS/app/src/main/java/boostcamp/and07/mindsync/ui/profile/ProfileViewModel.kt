package boostcamp.and07.mindsync.ui.profile

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import boostcamp.and07.mindsync.data.repository.profile.ProfileRepository
import boostcamp.and07.mindsync.ui.util.fileToMultiPart
import boostcamp.and07.mindsync.ui.util.toRequestBody
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel
    @Inject
    constructor(
        private val profileRepository: ProfileRepository,
    ) :
    ViewModel() {
        private val _uiState = MutableStateFlow(ProfileUiState())
        val uiState: StateFlow<ProfileUiState> = _uiState
        private val _event = MutableSharedFlow<ProfileUiEvent>()
        val event: SharedFlow<ProfileUiEvent> = _event
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState
    private val _event = MutableSharedFlow<ProfileUiEvent>()
    val event: SharedFlow<ProfileUiEvent> = _event
    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            viewModelScope.launch { _event.emit(ProfileUiEvent.ShowMessage(throwable.message.toString())) }
        }

        fun updateProfileUri(uri: Uri) {
            _uiState.update { uiState ->
                uiState.copy(imageUri = uri)
            }
        }

        fun updateNickName(nickname: String) {
            _uiState.update { uiState ->
                uiState.copy(nickname = nickname)
            }
        }

        fun setProfileImageFile(file: File) {
            _uiState.update { uiState ->
                uiState.copy(imageFile = file)
            }
        }

                }
            }
        }
    }
