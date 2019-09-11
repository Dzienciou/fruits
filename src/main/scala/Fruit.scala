sealed trait Fruit {
  val name: String
  val price: BigDecimal
}

object Fruit {

  case object Apple extends Fruit {
    val name = "Apple"
    val price = BigDecimal("0.6")
  }

  case object Orange extends Fruit {
    val name = "Orange"
    val price = BigDecimal("0.25")
  }

  val allFruits: Seq[Fruit] = Seq(Apple, Orange)
  def forName(name: String): Option[Fruit] = allFruits.find(_.name == name)
}