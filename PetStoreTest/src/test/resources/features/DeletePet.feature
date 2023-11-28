#language:hu
@DELETE
Jellemző: Ellenőrzöm az állat meglétét a korábbi

  @SMOKE
  Forgatókönyv vázlat: Állat hozzáadása
    * Hozzáadok a nyilvántartáshoz "<id>" azonosítóval "<name>" névvel egy "<categoryName>"
    * Ellenőrzöm, hogy bekerült a nyilvántartásba
    * Ellenőrzöm az állat meglétét
    * Kitörlöm az általam felvitt állatot
    * Ellenőrzöm a törlés utáni választ
    Példák:
      | id       | name  | categoryName |
      | randomID | Tyson | kutyát       |
