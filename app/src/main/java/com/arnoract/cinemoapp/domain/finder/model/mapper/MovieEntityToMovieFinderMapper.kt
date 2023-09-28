package com.arnoract.cinemoapp.domain.finder.model.mapper

import com.arnoract.cinemoapp.core.base.Mapper
import com.arnoract.cinemoapp.core.db.history.MovieEntity
import com.arnoract.cinemoapp.domain.finder.model.MovieFinder

object MovieEntityToMovieFinderMapper : Mapper<MovieEntity, MovieFinder> {
    override fun map(from: MovieEntity): MovieFinder {
        return MovieFinder(
            id = from.id,
            title = from.titleEn,
            genre = from.genre,
            synopsisEh = from.synopsisEn,
            posterUrl = from.posterUrl,
            releaseDate = from.releaseDate
        )
    }
}