import * as React from "react";
import { RouteComponentProps } from "react-router-dom";

interface Props extends RouteComponentProps<any> {}

const Home: React.FC<Props> = (props) => {
  return <div>Home</div>;
};

export default Home;
