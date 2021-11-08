DAT108 - F23 - 8. november 2021
-------------------------------

Hensikten med dette eksemplet er å vise hvordan vi kan isolere
testobjektet (currencyConverter) ved å bruke en stub for et objekt 
det samarbeider med (exchangeRateService).

For å få dette til:

- IKKE bruk static metoder. static hindrer polymorfisme og dermed
    muligheten til å bruke stand-ins for objekter når man tester.
    Må altså endre ExchangeRateService slik at metoden(e) ikke er
    static. Må derfor opprette et ExchangeRateService-objekt i 
    CurrencyConverter.
    
- Må tilrettelegge for mulig utbytting av objekter vi samhandler med.
    Utbyttingen kan skje i f.eks. konstruktør, set-metode eller
    ved å gi objektet som parameter i aktuell metode. Vi gjør det
    via set-metode, og bruker den opprinnelige ExchangeRateService
    som default.
    
- Objektet som skal erstatte ExchangeRateService må være av 
    "samme type", dvs. arve fra ExchangeRateService. Vi liker ikke
    å bruke arv som et triks! :) Foretrekker å innføre et interface
    i stedet som vi bruker som type i applikasjonen.
    
- Da lager vi oss en stub som vi kan bruke i testingen. Så injecter
    vi denne i den aktuelle testen.
    Teste: GREEN BAR :)
    
    
    
