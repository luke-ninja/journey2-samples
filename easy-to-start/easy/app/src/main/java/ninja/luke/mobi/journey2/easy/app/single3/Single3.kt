package ninja.luke.mobi.journey2.easy.app.single3

import android.os.Bundle
import android.view.View
import ninja.luke.mobi.journey2.easy.app.R
import ninja.luke.mobi.journey2.scope.single.J2SingleFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class Single3 : J2SingleFragment<Single3Route>(
    Single3Sdk,
    R.layout.fragment_single3
) {

    private val single3VM: Single3ViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.click).setOnClickListener {
            if (it.isEnabled) {
                it.isEnabled = false
                single3VM.handleLongRunningProcess()
            }
        }
        single3VM.liveData.observe(viewLifecycleOwner) {
            it?.let {
                route?.onSingle3GoNextOnLiveData()
            }
        }
    }

}