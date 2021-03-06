import CircularProgress from "@material-ui/core/CircularProgress";
import * as React from "react";
import { Redirect, RouteComponentProps } from "react-router-dom";
import { LISTING_SEARCH } from "../../util/api/AJAX";
import Navigation from "./../../components/Navigation/Navigation";
import SearchResults from "./../../components/SearchResults/SearchResults";

interface Props extends RouteComponentProps<any> {}

const Search: React.FC<Props> = (props) => {
  const params: string = props.location.search;

  const [paramsArr]: any = React.useState(
    params.replace("?", "").replace("=", ":").split("&")
  );
  const [results, setResults]: any = React.useState([]);
  const [isLoading, setLoading]: any = React.useState(true);

  React.useEffect(() => {
    const fetchListing = async () => {
      // Make axios get request with the params array
      await LISTING_SEARCH(paramsArr).then((response: any) => {
        if (response.status === 200) {
          setResults(response.data);
          setLoading(false);
        }
      });
    };

    fetchListing();
  }, [setResults, paramsArr]);

  if (
    params !== "" &&
    params.includes("location") &&
    params.includes("checkIn") &&
    params.includes("checkOut") &&
    paramsArr.length > 0
  ) {
    return (
      <>
        <div
          style={{
            width: "100%",
            display: "grid",
          }}
        >
          <Navigation
            isSearchNavbar={false}
            history={props.history}
            match={props.match}
            location={props.location}
          />
          {!isLoading ? (
            <div
              style={{
                marginLeft: "3vw",
                marginRight: "3vw",
                width: "94%",
              }}
            >
              <SearchResults
                history={props.history}
                location={props.location}
                match={props.match}
                results={results}
              />
            </div>
          ) : (
            <div style={{ placeItems: "center", textAlign: "center", display: "inline-block", width: "94%" }}>
              <CircularProgress />
            </div>
          )}
        </div>
      </>
    );
  }
  return <Redirect to="/home" />;
};

export default Search;
