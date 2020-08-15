import * as React from "react";
import { RouteComponentProps } from "react-router-dom";
import AppBar from "@material-ui/core/AppBar";
import "./Navigation.css";
import Button from "@material-ui/core/Button";
import PersonOutlineOutlinedIcon from "@material-ui/icons/PersonOutlineOutlined";

interface Props extends RouteComponentProps<any> {
  isSearchNavbar: boolean;
}

const Navigation: React.FC<Props> = (props) => {
  const [isOnTop, setIsOnTop] = React.useState(props.isSearchNavbar);

  return (
    <AppBar
      className={!isOnTop ? "navbar" : ""}
      elevation={0}
      style={{
        backgroundColor: isOnTop ? "transparent" : "white",
        color: isOnTop ? "transparent" : "white",
        marginBottom: "1vh"
      }}
    >
      <div
        style={{
          paddingLeft: "80px",
          paddingRight: "80px",
          minHeight: "8vh",
          lineHeight: "8vh",
        }}
      >
        <div
          style={{
            lineHeight: 1.5,
            height: "100%",
            display: "flex",
            verticalAlign: "middle",
          }}
        >
          <h3
            style={{
              color: !isOnTop ? "#FF385C" : "white",
              fontSize: "150%",
              float: "left",
              marginTop: "20px",
              marginBottom: "20px"
            }}
          >
            <b>CloneBnb</b>
          </h3>
          <Button
            style={{
              borderColor: isOnTop ? "white" : "",
              float: "right",
              borderRadius: "60px",
              width: "min-content",
              padding: "6px",
              marginLeft: "auto",
              marginTop: "20px",
              marginBottom: "20px"
            }}
            variant="outlined"
            className="profile-button"
          >
            <PersonOutlineOutlinedIcon style={{
              color: isOnTop ? "white" : "",
            }} />
          </Button>
        </div>
      </div>
    </AppBar>
  );
};

export default Navigation;
