import * as React from "react";
import { RouteComponentProps } from "react-router-dom";

interface Props extends RouteComponentProps<any> {}

const HomeTopBanner: React.FC<Props> = (props) => {
  return (
    <div>
      <h1>Home</h1>
    </div>
  );
};

export default HomeTopBanner;
