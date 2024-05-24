package ext.domain.screenmatch.model;

public enum Category {
    ACTION("Action", "Acción"),
    COMEDY("Comedy", "Comedia"),
    CRIME("Crime", "Crimen"),
    DRAMA("Drama", "Drama"),
    ROMANCE("Romance", "Romance");

    private String omdbCategory;
    private String spanishCategory;

    Category(String omdbCategory, String spanishCategory) {
        this.omdbCategory = omdbCategory;
        this.spanishCategory = spanishCategory;
    }

    public static Category fromString(String text) {
        for (Category category : Category.values()) {
            if (category.omdbCategory.equalsIgnoreCase(text)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Category not found: " + text);
    }

    public static Category fromSpanish(String text) {
        for (Category category : Category.values()) {
            if (category.spanishCategory.equalsIgnoreCase(text)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Categoría no encontrada: " + text);
    }
}