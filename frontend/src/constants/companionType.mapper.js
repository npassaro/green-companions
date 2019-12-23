export const COMPANION_TYPE = {
  none: 0,
  bad: 1,
  good: 2,
};

export const getCompanionType = (green, selectedGreen) => {
  if(selectedGreen.badCompanionsIds.includes(green.id)) {
    return COMPANION_TYPE.bad;
  } else if(selectedGreen.goodCompanionsIds.includes(green.id)) {
    return COMPANION_TYPE.good;
  } else {
    return COMPANION_TYPE.none;
  }
};
