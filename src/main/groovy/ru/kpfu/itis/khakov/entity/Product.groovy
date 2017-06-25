package ru.kpfu.itis.khakov.entity

/**
 * @author Khakov Rustam
 * Класс содержит данные о продукте
 */
class Product{
    int id
    Category category
    int capacity
    Storage storage

    public Product(int id, String categoryName, int capacity){
        this.id = id
        this.category = Category.valueOf(categoryName.toUpperCase())
        this.capacity = capacity
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category=" + category +
                ", capacity=" + capacity +
                ", storage=" + storage +
                '}';
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Product product = (Product) o

        if (capacity != product.capacity) return false
        if (id != product.id) return false
        if (category != product.category) return false
        if (storage != product.storage) return false

        return true
    }

    int hashCode() {
        int result
        result = id
        result = 31 * result + (category != null ? category.hashCode() : 0)
        result = 31 * result + capacity
        result = 31 * result + (storage != null ? storage.hashCode() : 0)
        return result
    }
}
