package zlc.season.rxdownload4.downloader

import okhttp3.ResponseBody
import retrofit2.Response
import zlc.season.rxdownload4.utils.isSupportRange

class DefaultDispatcher : Dispatcher {
    override fun dispatch(response: Response<ResponseBody>): Downloader {
        if (!response.isSuccessful) {
            throw IllegalStateException("Response is failed!")
        }

        return if (response.isSupportRange()) {
            RangeDownloader()
        } else {
            NormalDownloader()
        }
    }
}