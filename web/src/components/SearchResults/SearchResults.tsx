import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import Divider from "@material-ui/core/Divider";
import "./SearchResult.css";
import SearchResultCard from "./SearchResultCard";

interface Props extends RouteComponentProps<any> {
  results: Array<any>;
}

const SearchResults: React.FC<Props> = (props) => {
  return (
    <div
      style={{
        margin: "0 auto",
        textAlign: "center",
        display: "inline-block",
        overflowX: "hidden",
        width: "100%",
      }}
    >
      {/* Section above that says "Stays in"  */}

      <Divider />
      {props.results.map((listing: any, index: number) => (
        <div
          className={`listing-${index + 1}-${listing.id}`}
          key={`listing-${index}`}
          style={{
            width: "100%",
            paddingBottom: "2vh",
            cursor: "pointer",
          }}
        >
          <SearchResultCard
            listing={listing}
            location={props.location}
            match={props.match}
            history={props.history}
          />
          <Divider />
        </div>
      ))}
    </div>
  );
};

export default SearchResults;
