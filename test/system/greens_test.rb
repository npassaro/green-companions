require "application_system_test_case"

class GreensTest < ApplicationSystemTestCase
  setup do
    @green = greens(:green_one)
  end

  test "visiting the index" do
    visit greens_url
    assert_selector "h1", text: "Greens"
  end

  test "creating a Green" do
    visit greens_url
    click_on "New Green"

    fill_in "Description", with: @green.description
    fill_in "Grow period", with: @green.grow_period
    fill_in "Harvest period", with: @green.harvest_period
    fill_in "Name", with: @green.name
    fill_in "Sow period", with: @green.sow_period
    click_on "Create Green"

    assert_text "Green was successfully created"
    click_on "Back"
  end

  test "updating a Green" do
    visit greens_url
    click_on "Edit", match: :first

    fill_in "Description", with: @green.description
    fill_in "Grow period", with: @green.grow_period
    fill_in "Harvest period", with: @green.harvest_period
    fill_in "Name", with: @green.name
    fill_in "Sow period", with: @green.sow_period
    click_on "Update Green"

    assert_text "Green was successfully updated"
    click_on "Back"
  end

  test "destroying a Green" do
    visit greens_url
    page.accept_confirm do
      click_on "Destroy", match: :first
    end

    assert_text "Green was successfully destroyed"
  end
end
