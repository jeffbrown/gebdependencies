package gebdependencies

import geb.spock.GebSpec
import gebdependencies.pages.CreatePersonPage
import gebdependencies.pages.PersonListPage
import gebdependencies.pages.ShowPersonPage
import grails.testing.mixin.integration.Integration
import spock.lang.Stepwise


@Integration
@Stepwise
class PersonCrudFunctionalSpec extends GebSpec {

    void "test creating people"() {
        when:
        to CreatePersonPage

        then:
        at CreatePersonPage

        when:
        populateCreatePersonForm 'Geddy', 'Lee'

        then:
        at ShowPersonPage

        when:
        to CreatePersonPage

        then:
        at CreatePersonPage

        when:
        populateCreatePersonForm 'Alex', 'Lifeson'

        then:
        at ShowPersonPage
    }

    void "test retrieving people"() {
        when:
        to PersonListPage

        then:
        numberOfPersonRows == 2
    }
}
