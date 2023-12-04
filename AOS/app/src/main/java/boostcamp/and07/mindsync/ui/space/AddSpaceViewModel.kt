package boostcamp.and07.mindsync.ui.space

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AddSpaceViewModel @Inject constructor() : ViewModel() {
    private val _spaceName = MutableStateFlow<String>("")
    val spaceName: StateFlow<String> = _spaceName
    private val _spaceThumbnail = MutableStateFlow<String>("")
    val spaceThumbnail: StateFlow<String> = _spaceThumbnail

    fun onSpaceNameChanged(
        inputSpaceName: CharSequence,
        start: Int,
        before: Int,
        count: Int,
    ) {
        _spaceName.value = inputSpaceName.toString()
    }

    fun setSpaceThumbnail(thumbnailUrl: String) {
        _spaceThumbnail.value = thumbnailUrl
    }
}
