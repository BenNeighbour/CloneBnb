import * as React from "react";
import { RouteComponentProps } from "react-router-dom";

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
        marginTop: "10vh",
      }}
    >
      {props.results.map((listing: any, index: number) => (
        <p key={`listing-${index}`}>name: {listing.name}</p>
      ))}
    </div>
  );
};

export default SearchResults;
