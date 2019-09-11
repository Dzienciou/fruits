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

    "return correct value for list when taking discounts" in {
      CheckoutSystem.computeWithDiscounts(Seq("Apple", "Apple", "Orange", "Orange", "Orange")) must_== BigDecimal("1.1")
    }

    "return correct value for list when no discount applies" in {
      CheckoutSystem.computeWithDiscounts(Seq("Apple", "Orange", "Orange")) must_== BigDecimal("1.1")
    }

    "return correct value for list with non-trivial amounts" in {
      CheckoutSystem.computeWithDiscounts(Seq("Apple", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange")) must_== BigDecimal("1.95")
    }

    "return correct value for a big list" in {
      CheckoutSystem.computeWithDiscounts(Seq.fill(111)("Apple") ++ Seq.fill(55)("Orange")) must_== BigDecimal("42.85")
    }

  }

}
