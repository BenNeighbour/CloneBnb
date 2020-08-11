import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import { AppBar } from '@material-ui/core';

interface Props extends RouteComponentProps<any> {}

const Navigation: React.FC<Props> = (props) => {
  return (
    <AppBar
      style={{
        backgroundColor: "white",
        marginBottom: "1vh",
      }}
    >
      <div
        style={{
          paddingLeft: "80px",
          paddingRight: "80px",
          minHeight: "8vh",
        }}
      >
        <div
          style={{
            lineHeight: 1,
            height: "100%",
            paddingTop: "2.66vh",
            paddingBottom: "2.66vh",
          }}
        >
          <h3
            style={{
              color: "#FF385C",
              fontSize: "150%",
              padding: 0,
            }}
          >
            <b>CloneBnb</b>
          </h3>
        </div>
      </div>
    </AppBar>
  );
};

export default Navigation;
