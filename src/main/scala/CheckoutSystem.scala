object CheckoutSystem {
  def compute(articles: Seq[String]): BigDecimal = {
    articles.length * BigDecimal("0.6")
  }

}
