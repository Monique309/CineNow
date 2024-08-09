package com.devspacecinenow.common

import com.devspacecinenow.common.MovieDto

@kotlinx.serialization.Serializable

data class MovieResponse(
    val results: List<MovieDto>


)
