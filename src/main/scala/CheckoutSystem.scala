object CheckoutSystem {
  def compute(articles: Seq[String]): BigDecimal =
    articles.map(name => Fruit.forName(name))
      .collect { case Some(fruit) => fruit.price }
      .sum
}
