package ru.kpfu.itis.khakov.entity

/**
 * Складыное помещение
 * @author Khakov Rustam
 */
class Storage implements Comparable<Storage>{
    String name
    List<Product> products
    Set<Category> categories
    int capacity


    @Override
    int compareTo(Storage o) {
        if (this.capacity> o.capacity){
            return 1
        }else if(this.capacity == o.capacity){
            return 0
        }
        return -1
    }
    /**
     * добавляет продукт, если его объем не превышает свободного пространства
     * @param product - добавляемый продукт в склад
     */
    public void addProduct(Product product){
        if(products == null){
            products = new LinkedList<Product>()
        }
        if(capacity> product.capacity) {
            capacity -= product.capacity
            products.add(product)
        }
    }

    @Override
    public String toString() {
        return "Storage " + name
    }
}
