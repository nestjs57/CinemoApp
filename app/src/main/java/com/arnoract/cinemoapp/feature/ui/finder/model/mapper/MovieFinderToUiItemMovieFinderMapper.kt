package com.arnoract.cinemoapp.feature.ui.finder.model.mapper

import com.arnoract.cinemoapp.core.base.Mapper
import com.arnoract.cinemoapp.core.util.DateFormatUtils
import com.arnoract.cinemoapp.domain.finder.model.MovieFinder
import com.arnoract.cinemoapp.feature.ui.finder.model.UiItemMovieFinder

object MovieFinderToUiItemMovieFinderMapper : Mapper<MovieFinder, UiItemMovieFinder> {
    override fun map(from: MovieFinder): UiItemMovieFinder {
        return UiItemMovieFinder(
            id = from.id,
            imageUrl = from.posterUrl,
            genre = from.genre,
            title = from.title,
            releaseDate = DateFormatUtils.formatMonthDateCommaYear(from.releaseDate)
        )
    }
}