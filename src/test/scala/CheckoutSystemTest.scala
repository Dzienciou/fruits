class CheckoutSystemTest extends org.specs2.mutable.Specification {

  "CheckoutSystem" should {
    "return 0.0 for empty list" in {
      CheckoutSystem.compute(Seq.empty[String]) must_== BigDecimal("0.0")
    }
    "return correct value for list of Apples" in {
      CheckoutSystem.compute(Seq("Apple", "Apple", "Apple")) must_== BigDecimal("1.8")
    }

    "return correct value for list of Apples and Oranges" in {
      CheckoutSystem.compute(Seq("Apple", "Orange", "Apple", "Orange")) must_== BigDecimal("1.7")
    }
  }

}
