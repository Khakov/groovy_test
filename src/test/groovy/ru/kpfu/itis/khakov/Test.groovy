package ru.kpfu.itis.khakov

import ru.kpfu.itis.khakov.entity.*
import ru.kpfu.itis.khakov.utils.StorageUtil

/**
 * @author Khakov Rustam
 */


/**
 * функция для теста системы
 */
def testSystem(){
    StorageUtil.products = []
    StorageUtil.setStorages(createStorages())
    StorageUtil.setProducts(createProducts())
    for (Product product: StorageUtil.products){
        println(product)
    }
}
/**
 * функция, которая создает список тестовых данных складов
 * @return список складов
 */
def createStorages() {
    List<Storage> storages = new LinkedList<Storage>()
    storages.add(new Storage(name: 'First 1', capacity: 12,
            categories: new HashSet<Category>([Category.FOOD, Category.MEDECINE])))
    storages.add(new Storage(name: 'Second 2', capacity: 15,
            categories: new HashSet<Category>([Category.VECHICLE, Category.MEDECINE])))
    return storages
}
/**
 * создает список продуктов
 * @return возвращает сгенерированный  список продуктов
 */
def createProducts(){
    List<Product> products = new LinkedList<Product>()
    products.add(new Product(1, 'Food', 3))
    products.add(new Product(2, 'Vechicle', 2))
    products.add(new Product(3, 'Vechicle', 2))
    products.add(new Product(4, 'Vechicle', 2))
    products.add(new Product(5, 'Vechicle', 10))

    return products
}
testSystem()
