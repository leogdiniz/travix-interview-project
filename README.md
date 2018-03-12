**About my solution**

Running the application and going to http://localhost:8080/v1/flight/list a json array with 5 elements will be shown.
In this list, there will be flights from both CrazyAir and ToughJet ordered by fare.

**My approach**

My intention was to use a design pattern that would make it easy to aggregate other services if needed.
The way it was built, any new service would only need to implement the interface BusyFlightsAdapter and it would be ready to go.
I used Lombok in order to remove the boilerplate code of getters, setters and builders. Since it uses java aspect it doesn't represent any harm performance wise.

For the tests, I tried to focus on the requirements such as the fare rounded to 2 decimals, the date being in the ISO format and that the controller is able to get the data from the request correctly.

**What I could've done with more time**
I would've customized the validation messages for number of passengers over 4 people and origin parameter longer than 3 letters.
The data from CrazyAir and ToughJet are hardcoded.
I thought of using an H2 database to save the data and select from it but since it would come from an API I did not spend time on it.  
I also thought of integrating with a real service like [this one](https://developer.lufthansa.com/docs/read/api_basics/Building_a_Request) so I could apply the request data to filter but it would spend more than 90 minutes.
 
