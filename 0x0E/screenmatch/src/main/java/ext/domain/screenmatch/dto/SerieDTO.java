package ext.domain.screenmatch.dto;

import ext.domain.screenmatch.model.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record SerieDTO( Long id,
        String title,
        Integer seasons,
        Double rating,
        String poster,
        Category genre,
        String actors,
        String synopsis
) {}
