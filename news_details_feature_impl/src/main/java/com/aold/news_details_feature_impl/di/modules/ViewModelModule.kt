package com.aold.news_details_feature_impl.di.modules

import com.aold.core.core.di.FeatureScope
import com.aold.core.core.platform.viewmodel.BaseViewModel

/**
 * @author Kirilin Yury on 18.03.2023.
 */

@Module
internal interface ViewModelModule {

    @Binds
    fun provideDetailsViewModel(viewModel: NewsDetailsViewModel): BaseViewModel

    @Binds
    fun provideDetailsViewModelFactory(factory: NewsDetailsViewModel.Factory): BaseViewModel.BaseViewModelFactory

    @Binds
    @FeatureScope
    fun provideDetailsCommunications(communications: NewsDetailsCommunications.Base): NewsDetailsCommunications

    @Binds
    fun provideDetailsStateCommunicator(communicator: NewsDetailsStateCommunicator.Base): NewsDetailsStateCommunicator

    @Binds
    fun provideDetailsCommunicator(communicator: NewsDetailsCommunicator.Base): NewsDetailsCommunicator

    @Binds
    fun provideDetailsRequestHandler(handler: DetailsRequestHandler.Base): DetailsRequestHandler
}