package ru.kpfu.itis.khakov.utils

import ru.kpfu.itis.khakov.entity.Product
import ru.kpfu.itis.khakov.entity.Storage

import java.util.logging.Logger

/**
 * Класс, осуществляющий взаимодействие с складом и товарами
 * @author Khakov Rustam
 */
class StorageUtil {
    static Logger logger = Logger.getLogger('StorageUtil')
    static List<Storage> storages
    static List<Product> products
    /**
     * Продуст добваится в склад при условии, что в данный склад можно добавлять в склад данной категории
     * и свободного места в данном складе больше, чем другом складе (для равномерной загрузки).
     * В случае отсутсвия места в складе выдается сообщение
     * Если нужно учитывать, что идентификаторы не должны совпадать, то нужно изменить лист на множество,
     * добавить try-catch блок и выбрасывать DuplicateIdException, при условии,что не добавится значение
     * в множество
     * @param product - продукт который нужно добавить
     */
    static void addNewProduct(Product product) {
        Storage addingStorage = null
        if (products == null) {
            products = new LinkedList<Product>()
        }
        for (Storage storage : storages) {
            if (storage.categories.contains(product.category) &&
                    (addingStorage == null || addingStorage < storage)
                    && storage.capacity >= product.capacity) {
                addingStorage = storage
            }
        }
        if (addingStorage != null) {
            addingStorage.addProduct(product)
            product.storage = addingStorage
        } else {
            logger.print("for product with id= $product.id does not have free capacity on storage")
        }
        products.add(product)
    }
    /**
     * Добавляет данные товары на склады, формирует список продуктов
     * @param addProducts лист продоуктов, для добавления в список
     */
    static void setProducts(List<Product> addProducts) {
        for (Product product : addProducts) {
            addNewProduct(product)
        }
    }
}
