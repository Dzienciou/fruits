import Fruit.{Apple, Orange}

object CheckoutSystem {
  private def computeBasePrice(articles: Seq[Fruit]): BigDecimal =
    articles.map(fruit => fruit.price).sum

  private def computeDiscounts(articles: Seq[Fruit]): BigDecimal = {
    (for {(fruit, count) <- articles.groupBy(identity).mapValues(_.size).toSeq }
      yield fruit match {
        case Apple => Math.floor(count / 2) * Apple.price
        case Orange => Math.floor(count / 3) * Orange.price
        case _: Fruit => BigDecimal("0.0")
        }).sum
  }

  private def parseNames(articlesNames: Seq[String]): Seq[Fruit] =
    articlesNames.map(name => Fruit.forName(name))
      .collect { case Some(fruit) => fruit }

  def compute(articles: Seq[String]): BigDecimal = (computeBasePrice _ compose parseNames) (articles)

  def computeWithDiscounts(articles: Seq[String]): BigDecimal = {
    val fruits: Seq[Fruit] = parseNames(articles)
    computeBasePrice(fruits) - computeDiscounts(fruits)
  }

}
